import { useState } from "react";
import { Button } from "react-bootstrap";
import Card from "react-bootstrap/esm/Card";
import { Link } from "react-router-dom";
import { Product } from '../../services/Product.model';
interface prop{
    product: Product
}
export function CardProduct(props: prop){

    const [product, setProduct] = useState(props.product);
    return (<>
    <Card style={{ width: '18rem' , margin: '8px'}}>
    <Link to={"/product/"+product.id}><Card.Img variant="top" src={"/img/"+ product.imagen} /></Link>
    <Card.Body>
      <Card.Title>{product.instrumento}</Card.Title>
      <Card.Text>
        {product.descripcion}
      </Card.Text>
      <Card.Text>
        $ {product.precio}
      </Card.Text>
      <Button variant="primary">Comprar</Button>
    </Card.Body>
    </Card>
  </>)
}