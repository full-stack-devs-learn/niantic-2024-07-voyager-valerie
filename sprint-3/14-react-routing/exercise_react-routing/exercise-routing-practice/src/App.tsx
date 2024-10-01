import './App.css'
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Header from './components/shared/header/Header'
import Home from './components/Home'
import ProductList from './components/products/product-list/ProductList'
import ProductSearch from './components/products/product-search/ProductSearch'
import ProductEdit from './components/products/product-edit/ProductEdit'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductDetails from './components/products/product-details/ProductDetails'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryList from './components/categories/category-list/CategoryList'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'

function App() {

  return (
    <Router>
      <Header></Header>

      <main className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/products" element={<ProductList/>}>
            <Route path="search" element={<ProductSearch/>}/>
            <Route path="edit" element={<ProductEdit/>}/>
            <Route path="add" element={<ProductAdd/>}/>
            <Route path=":productId" element={<ProductDetails/>}/>
          </Route>
          <Route path="/categories" element={<CategoryList/>}>
            <Route path=":categoryId" element={<CategoryDetails/>}/>
            <Route path="add" element={<CategoryAdd/>}/>
            <Route path="edit" element={<CategoryEdit/>}/>
          </Route>
        </Routes>
      </main>
    </Router>
  )
}

export default App
