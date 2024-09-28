import axios from 'axios'
import { ProductsResponse } from '../components/products/models/classes/products-response';

class ProductService
{
    async getAllProducts(): Promise<ProductsResponse>
    {
        const response = await axios.get<ProductsResponse>("http://localhost:8080/products/all");
        return response.data;
    }
}

const productService = new ProductService()
export default productService;