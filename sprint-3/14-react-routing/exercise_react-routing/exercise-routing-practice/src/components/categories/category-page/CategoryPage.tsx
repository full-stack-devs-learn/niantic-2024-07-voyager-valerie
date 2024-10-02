import { useEffect, useState } from 'react';
import { Category } from '../../../models/category';
import { Route, Routes } from 'react-router-dom';
import CategoryList from '../category-list/CategoryList';
import CategoryAdd from '../category-add/CategoryAdd';
import CategoryEdit from '../category-edit/CategoryEdit';
import CategoryDetails from '../category-details/CategoryDetails';
import CategoryService from '../../../services/categories-service';

export default function CategoryPage() {
  const [categories, setCategories] = useState<Category[]>([]);

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
    <div>
      <h1>Categories</h1>

        {/* passes categories prop here */}
        <CategoryList categories={categories} />

      <Routes>
        {/* nested routes for categories */}
        <Route path=":categoryId" element={<CategoryDetails />} />
        <Route path="add" element={<CategoryAdd />} />
        <Route path=":categoryId/edit" element={<CategoryEdit />} />
      </Routes>
    </div>
  );
}