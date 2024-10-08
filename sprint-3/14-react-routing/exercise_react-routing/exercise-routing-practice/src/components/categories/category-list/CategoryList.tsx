import { Link, useNavigate } from "react-router-dom"
import { Category } from "../../../models/category";
import { useEffect, useState } from "react";
import CategoryService from "../../../services/categories-service";

export default function CategoryList()
{
  const [categories, setCategories] = useState<Category[]>([])
  const navigate = useNavigate()

  useEffect(() => {

    const categoryService = new CategoryService()

    async function fetchCategories() {
        try {
          const result = await categoryService.getCategories()
          console.log(result)
          setCategories(result);
        } catch (error) {
          console.error("Error fetching categories", error)
        }
      }
      fetchCategories()
    }, [])
    return (
        <>
        <div>
          <button onClick={() => navigate('add')} className="btn btn-primary mb-3">
            Add Category
          </button>
          <ul>
            {categories.map((category: Category) => (
              <li key={category.categoryId}>
                <Link to={`/categories/${category.categoryId}`}>
                  <strong>{category.categoryName}</strong>
                </Link>
                <p>{category.description}</p>
              </li>
            ))}
          </ul>
        </div>
        </>
      )
}