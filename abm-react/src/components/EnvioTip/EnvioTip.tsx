import { Image } from "react-bootstrap";


export function EnvioTip(params:{precio:number|string}){
    const {precio} = params;
    return (
        <div>
            {precio === 'G'?
                <p className="text-success"><span><Image src="/img/truck.svg"></Image></span> Envio Gratis</p>:
                <p>Costo envio: $ {precio} </p>
            }
        </div>
    )
}
