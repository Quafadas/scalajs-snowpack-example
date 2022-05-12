import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import com.raquo.laminar.api.L._
import scala.scalajs.js.JSON
import org.scalajs.dom
import org.scalajs.dom.html
import viz.Utils
import viz.vega.plots.BarChart
import viz.dsl.Conversion.u
import viz.dsl.vega.*

object Main {

  val newDiv = div(
    height :="40vmin", width := "100vmin", idAttr := "viz",
    onMountCallback{ nodeCtx =>
      val plotDiv : html.Div = nodeCtx.thisNode.ref
      val axisOrient : TitleOrientEnum = "top"
      val newAxis : Axis= Axis(orient = axisOrient, scale = "xscale")      
      BarChart(
        List(
          viz.Utils.fillDiv,
          viz.Utils.removeXAxis,
          spec => spec("axes") = spec("axes").arr :+ newAxis.u
        )
      )(using plotDiv)
    }
   ) 

  def main(args: Array[String]): Unit = {
    render(dom.document.getElementById("app"), newDiv)
    
  }
}
