import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { ProductsLayout } from '../views/Products/ProductsLayout';
import { InfoProduct } from '../views/InfoProducts/InfoProduct';

export function AppRouter(){
    return (
        <Routes>
            <Route path="/products" element={<ProductsLayout></ProductsLayout>}/>
            <Route path="/" element={<ProductsLayout></ProductsLayout>}/>
            <Route path="/product/:id" element={<InfoProduct></InfoProduct>}/>
        </Routes>   
    )
}