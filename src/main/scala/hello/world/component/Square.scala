package hello.world.component

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Square extends Component {

  case class State(value: Option[String])

  def initialState: State = State(None)

  case class Props(index: Int)

  def render(): ReactElement = {
    button(
      className := "square",
      onClick := (_ => setState(State(Some("X"))))
    )(
      state.value
    )
  }
}
