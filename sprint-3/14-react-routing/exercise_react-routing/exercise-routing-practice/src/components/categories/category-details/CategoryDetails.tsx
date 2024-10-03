import { useParams, useNavigate } from "react-router-dom"
import { useEffect, useState } from "react"
import { Category } from "../../../models/category"
import CategoryService from "../../../services/categories-service"

export default function CategoryDetails()
{
    const { categoryId } = useParams()
    const [category, setCategory] = useState<Category | null>(null)
    const navigate = useNavigate()

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

    async function handleDelete() {
      if (window.confirm("Are you certain you want to delete this category?")) {
        try 
        {
          const categoryService = new CategoryService()
          await categoryService.deleteCategory(Number(categoryId))
          navigate('/categories')
        }
        catch (error) 
        {
          console.error("Error deleting this category", error)
        }
      }
    }

    return (
        <>
        {category ? (
          <div id="category-details">
            <div className="d-flex mb-2">
              <button onClick={() => navigate('edit')} className="btn btn-primary mb-3">Edit Category</button>
              <button onClick={handleDelete} className="btn btn-danger mb-3 ms-2">Delete Category</button>
            </div>
            <h2>{category.categoryName}</h2>
            <p>{category.description}</p>
          </div>
        ) : (
          <p>Loading category details...</p>
        )}
      </>
    )
}