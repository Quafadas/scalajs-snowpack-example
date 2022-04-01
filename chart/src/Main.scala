import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import com.raquo.laminar.api.L._
import org.scalajs.dom
import viz.Utils
import viz.vega.plots.BarChart
import viz.PlotTarget

object Main {

  val newDiv = div(
    height :="40vmin", width := "100vmin", idAttr := "viz",
    onMountCallback{ nodeCtx =>      
      BarChart(List(viz.Utils.fillDiv))(using nodeCtx.thisNode.ref)      
    }
  )  

  def main(args: Array[String]): Unit = {
    render(dom.document.getElementById("app"), newDiv)
    
  }
}
