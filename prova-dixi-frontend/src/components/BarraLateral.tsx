import { Home, FileText, Clock} from "lucide-react"
import { BarraLateralItem } from "./BarraLateralItem";
import logo from "../assets/white-logo.png"

export function BarraLateral() {
  return (
    <aside className="fixed top-0 left-0 h-screen w-40 bg-sky-700 text-white flex flex-col">

      <div className="flex items-center justify-center py-10">
        <img src={logo} alt="Logo" className="h-30 transition-transform duration-300 hover:scale-110"/>
      </div>

      <nav className="flex flex-col border-y border-white/20 divide-y divide-white/20">
        <BarraLateralItem
            pagina="/bater-ponto"
            descricao="Bater Ponto"
            icone={<Clock size={40}/>}
        />

        <BarraLateralItem
            pagina="/historico"
            descricao="Histórico de Ponto"
            icone={<FileText size={40}/>}
        />

      </nav>

    </aside>
  )
}
