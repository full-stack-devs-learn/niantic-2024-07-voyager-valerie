import './App.css'
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Header from './components/shared/header/Header'
import Home from './components/home/Home'
import ProductList from './components/products/product-list/ProductList'
import ProductSearch from './components/products/product-search/ProductSearch'
import ProductEdit from './components/products/product-edit/ProductEdit'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductDetails from './components/products/product-details/ProductDetails'
import CategoryPage from './components/categories/category-page/CategoryPage'

function App() {

  return (
    <Router>
      <Header />

      <main className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<ProductList />}>
            <Route path="search" element={<ProductSearch/>}/>
            <Route path=":productId/edit" element={<ProductEdit />} />
            <Route path="add" element={<ProductAdd />} />
            <Route path=":productId" element={<ProductDetails />} />
          </Route>
          <Route path="/categories/*" element={<CategoryPage />} />
        </Routes>
      </main>
    </Router>
  )
}

export default App
