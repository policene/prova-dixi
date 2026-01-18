type CabecalhoProps = {
    titulo: string
    descricao: string
}

export function Cabecalho ({titulo, descricao} : CabecalhoProps) {
    return (
        <div className="flex flex-col items-start p-10">
            <h1 className="text-sky-700 text-4xl">{titulo}</h1>
            <p>{descricao}</p>
        </div>
    )
}