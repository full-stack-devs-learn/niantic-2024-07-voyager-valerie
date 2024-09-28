import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.js'
import './index.css'

import 'bootswatch/dist/united/bootstrap.min.css'
//import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.js'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
