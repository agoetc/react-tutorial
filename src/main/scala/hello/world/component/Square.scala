package hello.world.component

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._


@react class Square extends StatelessComponent {
  case class Props(index: Int)

  def render(): ReactElement = {
    button(className := "square")(
      props.index
    )
  }
}
