import { useEffect, useState } from 'react';
import { ProductService } from '../../services/ProductService';
import { Product } from '../../services/Product.model';
import { useParams } from 'react-router-dom';
import { Image } from 'react-bootstrap';
import { EnvioTip } from '../../components/EnvioTip/EnvioTip';

export function InfoProduct(){
    const {id} = useParams();
    const [product, setProduct] = useState<Product>();
    

    useEffect(()=>{
        if(Number.parseInt(id!) === undefined)
            return;
        new ProductService().getById(Number.parseInt(id!))
            .then((p)=>{console.log(p);setProduct(p)})
            .catch(()=>{})
    },[]);
    return (
    <>  {product &&
        (<div className="d-flex m-4" style={{height:'50vh'}}>
            <div className="container-fluid" style={{}}>
                <div className='d-flex justify-content-center align-items-center p-2'>
                    <Image src={'/img/'+product.imagen}></Image>
                </div>
                <div>
                    <p>{product.descripcion}</p>
                </div>
            </div>
            <div className="p-2" style={{minWidth:'400px'}}>
                <div>
                    <p>{product.cantidadVendida} vendidos</p>
                    <h1>{product.instrumento}</h1>
                </div>
                <div>
                    <p>Marca: <span>{product.marca}</span></p>
                    <p>Modelo: <span>{product.modelo}</span></p>
                </div>
                <p className='text-warning'>$ {product.precio}</p>
                <EnvioTip precio={product.costoEnvio}></EnvioTip>
            </div>
        </div>)
        }
    </>)
}