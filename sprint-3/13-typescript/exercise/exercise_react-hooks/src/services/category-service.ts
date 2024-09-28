import axios from 'axios'
import { CategoriesResponse } from '../components/categories/models/categories-response';

class CategoryService
{
    baseUrl = 'http://localhost:8080/categories'

    async getAllCategories(): Promise<CategoriesResponse>
    {
        const response = await axios.get<CategoriesResponse>("http://localhost:8080/categories");
        return response.data;
    }

    async add(category)
    {
        const response = await axios.post(this.baseUrl, category);
        return response.data;
    }

    async delete(categoryId)
    {
        await axios.delete(`${this.baseUrl}/${categoryId}`)
    }
}

const categoryService = new CategoryService()
export default categoryService;