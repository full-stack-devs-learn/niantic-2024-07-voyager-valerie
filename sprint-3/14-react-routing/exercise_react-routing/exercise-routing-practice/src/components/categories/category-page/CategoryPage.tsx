import { Route, Routes } from 'react-router-dom';
import CategoryList from '../category-list/CategoryList';
import CategoryAdd from '../category-add/CategoryAdd';
import CategoryEdit from '../category-edit/CategoryEdit';
import CategoryDetails from '../category-details/CategoryDetails';

export default function CategoryPage() { 

  return (
    <div>
      <h1>Categories</h1>

      <Routes>
        {/* nested routes for categories */}
        <Route path='' element={<CategoryList />} />
        <Route path=':categoryId' element={<CategoryDetails />} />
        <Route path='add' element={<CategoryAdd />} />
        <Route path=':categoryId/edit' element={<CategoryEdit />} />
      </Routes>
    </div>
  );
}