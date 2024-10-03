import axios from "axios";
import { Category } from "../models/category";

export default class CategoryService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

    async getCategories(): Promise<Category[]>
    {
        try{
            const response = await axios.get<Category[]>(this.baseUrl)
            return response.data
        }
        catch (error){
            console.error("Error fetching categories:", error)
            throw error
        }

    }

    async getCategoriesById(categoryId: number): Promise<Category>{
        try{
            const url = `${this.baseUrl}/${categoryId}`
            const response = await axios.get<Category>(url)
            return response.data
        }
        catch (error){
            console.error(`Error fetching category with ID ${categoryId}:`, error)
            throw error
        }
    }

    async addCategories(category: Category): Promise<Category>
    {
        try{
            const response = await axios.post<Category>(this.baseUrl, category)
            return response.data
        }
        catch (error) {
            console.error("Error adding category", error)
            throw error
        }

    }

    async updateCategory(category : Category): Promise<void>
    {
        try{
            const url = `${this.baseUrl}/${category.categoryId}`
            await axios.put<void>(url, category)
        }
        catch (error){
            console.error("Error updating this category", error)
        }

    }

    async deleteCategory(categoryId: number): Promise<void>
    {
        try{
            const url = `${this.baseUrl}/${categoryId}`
            await axios.delete<void>(url)
        }
        catch (error) {
            console.error("Error deleting this category", error)
            throw error
        }

    }
}
