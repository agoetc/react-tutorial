package hello.world.component

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object Square {


  case class Props(value: Option[String], onClick: () => Unit)

  val component: FunctionalComponent[Props] = FunctionalComponent[Props] { props =>
    button(
      className := "square",
      onClick := props.onClick
    )(
      props.value
    )
  }
}
