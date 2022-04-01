import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import com.raquo.laminar.api.L._
import scala.scalajs.js.JSON
import org.scalajs.dom
import viz.Utils
import viz.vega.plots.BarChart
import viz.PlotTarget
import viz.vega.vegaTypings.axisMod._

object Main {


  val newDiv = div(
    height :="40vmin", width := "100vmin", idAttr := "viz",
    onMountCallback{ nodeCtx =>
      val axis = Axis(AxisOrient.top, "xscale").setTitle("DSL Baby!") // This line kinda sorta proves we have a DSL...           
      BarChart(
        List(
          viz.Utils.fillDiv,
          viz.Utils.removeXAxis,
          spec => spec("axes") = (spec("axes").arr ++ List(ujson.read(JSON.stringify(axis))))
        )
      )(using nodeCtx.thisNode.ref)
    }
   ) 

  def main(args: Array[String]): Unit = {
    render(dom.document.getElementById("app"), newDiv)
    
  }
}
