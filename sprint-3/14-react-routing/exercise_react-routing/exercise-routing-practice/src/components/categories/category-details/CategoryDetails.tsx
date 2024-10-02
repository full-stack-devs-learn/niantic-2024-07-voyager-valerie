import { useParams } from "react-router-dom"
import { useEffect, useState } from "react"
import { Category } from "../../../models/category"
import CategoryService from "../../../services/categories-service"

export default function CategoryDetails()
{
    const { categoryId } = useParams()
    const [category, setCategory] = useState<Category | null>(null)

    useEffect(() => {

      const categoryService = new CategoryService()

        async function fetchCategoryDetails() {
            try 
            {
                const response = await categoryService.getCategoriesById(Number(categoryId))
                console.log('Fetched category:', response)
                setCategory(response)
            }
            catch (error) 
            {
                console.error("Error fetching category details", error)
            }
        }
        fetchCategoryDetails()
    }, [categoryId])

    return (
        <>
        {category ? (
          <div>
            <button>Add</button>
            <button>Edit</button>
            <h4>{category.categoryName}</h4>
            <p>{category.description}</p>
          </div>
        ) : (
          <p>Loading category details...</p>
        )}
      </>
    )
}