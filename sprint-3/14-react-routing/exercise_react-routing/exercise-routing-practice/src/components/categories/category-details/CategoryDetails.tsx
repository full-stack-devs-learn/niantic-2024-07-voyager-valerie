import { useParams } from "react-router-dom"
import { useEffect, useState } from "react"
import axios from "axios"
import { Category } from "../../../models/category"

export default function CategoryDetails()
{
    const { categoryId } = useParams()
    const [category, setCategory] = useState<Category | null>(null)

    useEffect(() => {
        async function fetchCategoryDetails() {
            try 
            {
                const response = await axios.get<Category>(`http://localhost:8080/${categoryId}`)
                setCategory(response.data)
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
            <h4>{category.categoryName}</h4>
            <p>{category.description}</p>
          </div>
        ) : (
          <p>Loading category details...</p>
        )}
      </>
    )
}