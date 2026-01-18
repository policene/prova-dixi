import { Link, useLocation } from "react-router-dom"

type BarraLateralItemProps = {
    icone: React.ReactNode
    descricao: string
    pagina: string
}

export function BarraLateralItem ({icone, descricao, pagina} : BarraLateralItemProps) {
    const { pathname } = useLocation()
    const paginaAtual = pathname === pagina

    return (
        <Link 
            to={pagina} 
            className={`
                    h-24
                    w-full
                    flex
                    flex-col
                    items-center
                    justify-center
                    transition
                    ${paginaAtual ? "bg-sky-800" : "hover:bg-sky-800"}
                `} >
            {icone}
            <span >{descricao}</span>
        </Link>
    )
}