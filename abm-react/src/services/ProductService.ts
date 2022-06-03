import { Product } from './Product.model';

export class ProductService {

    private protocol: string = window.location.protocol;
    private host: string = "localhost:8080";
    constructor() {
        
    }

    async getAll() {
        const products:Product[] = await (await fetch(`${this.protocol}//${this.host}/instrumentos`)).json()
        return [...products];
    }

    async getById(idProduct:number) {
        const product:Product = await (await fetch(`${this.protocol}//${this.host}/instrumentos/${idProduct}`)).json()
        return product;
    }
}