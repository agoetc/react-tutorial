package hello.world.component

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._


@react class Board() extends Component {
  type Props = Unit

  case class State(squares: Seq[Option[String]], xIsNext: Boolean)

  def initialState: State = State(squares = Seq.fill(9)(None), xIsNext = true)

  def render(): ReactElement = {

    val status = calculateWinner(this.state.squares) match {
      case Some(winner) => s"Winner: $winner"
      case None => s"Next player: ${getPlayer}"
    }

    div()(
      div(className := "status")(status),
      div(className := "board-row")((0 to 2).map(renderSquare)),
      div(className := "board-row")((3 to 5).map(renderSquare)),
      div(className := "board-row")((6 to 8).map(renderSquare))
    )
  }


  private def handleClick(index: Int): Unit = {
    if (calculateWinner(state.squares).isDefined || state.squares(index).isDefined) {
      ()
    } else {
      val updatedSquare: Seq[Option[String]] = state.squares.updated(index, Some(getPlayer))
      this.setState(State(updatedSquare, !state.xIsNext))
    }
  }

  private def renderSquare(index: Int): ReactElement = {
    Square(state.squares(index), () => handleClick(index))
  }

  private def getPlayer: String = if (state.xIsNext) "X" else "O"

  private def calculateWinner(squares: Seq[Option[String]]): Option[String] = {
    val lines = Seq(
      Seq(0, 1, 2),
      Seq(3, 4, 5),
      Seq(6, 7, 8),
      Seq(0, 3, 6),
      Seq(1, 4, 7),
      Seq(2, 5, 8),
      Seq(0, 4, 8),
      Seq(2, 4, 6),
    )


    lines.find(line =>
      squares(line.head).isDefined &&
        squares(line.head) == squares(line(1)) &&
        squares(line.head) == squares(line(2)))
      .flatMap(line => squares(line.head))
  }
}