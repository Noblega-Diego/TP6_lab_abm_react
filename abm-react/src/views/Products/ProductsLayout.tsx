import { CardProduct } from '../../components/CardProduct/CardProduct';
import { useEffect, useState } from 'react';
import { ProductService } from '../../services/ProductService';
import { Product } from '../../services/Product.model';

export function ProductsLayout(){

    const [products, setProducts] = useState<Product[]>([]);
    useEffect(()=>{
        new ProductService().getAll()
            .then((list:Product[])=>{setProducts(list)})
            .catch(()=>{})
    },[]);
    return (
    <>
        <div className="container p-2 d-flex flex-wrap justify-content-center">
            {products.map((p)=>{
                return (<CardProduct key={p.id} product={p}></CardProduct>)
            })}
        </div>
    </>)
}