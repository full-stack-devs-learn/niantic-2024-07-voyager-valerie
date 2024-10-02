import { Link } from "react-router-dom"
import { Category } from "../../../models/category"

interface CategoryListProps {
    categories: Category[];
  }

export default function CategoryList({ categories }: CategoryListProps)
{
    return (
        <>
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
        </>
      )
}