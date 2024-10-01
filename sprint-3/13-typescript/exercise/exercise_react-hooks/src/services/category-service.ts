import axios from 'axios'
import { Categories } from '../components/categories/models/categories';

class CategoryService
{
    baseUrl = 'http://localhost:8080/categories'

    async getAllCategories(): Promise<Categories>
    {
        const response = await axios.get<Categories>(this.baseUrl);
        return response.data;
    }

    async add(category: Categories): Promise<Categories>
    {
        const response = await axios.post<Categories>(this.baseUrl, category);
        return response.data;
    }

    async delete(categoryId: number): Promise<void>
    {
        await axios.delete(`${this.baseUrl}/${categoryId}`)
    }
}

const categoryService = new CategoryService()
export default categoryService;