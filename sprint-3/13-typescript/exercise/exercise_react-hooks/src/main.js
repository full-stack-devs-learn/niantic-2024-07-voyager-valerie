"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const react_1 = require("react");
const client_1 = require("react-dom/client");
const App_jsx_1 = __importDefault(require("./App.jsx"));
require("./index.css");
require("bootswatch/dist/united/bootstrap.min.css");
//import 'bootstrap/dist/css/bootstrap.min.css'
require("bootstrap/dist/js/bootstrap.js");
(0, client_1.createRoot)(document.getElementById('root')).render(<react_1.StrictMode>
    <App_jsx_1.default />
  </react_1.StrictMode>);
