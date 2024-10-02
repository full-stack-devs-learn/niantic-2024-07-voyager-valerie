import { Link } from "react-router-dom"

export default function Header()
{
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <div className="container-fluid d-flex align-items-center">
                <Link className="navbar-brand" to="/">Northwind React Router Project</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarColor02">
                    <ul className="navbar-nav ms-auto d-flex flex-row align-items-center">
                        <li className="nav-item me-3">
                            <Link className="nav-link" to="/">Home</Link>
                        </li>
                        <li className="nav-item me-3">
                            <Link className="nav-link" to="/categories">Categories</Link>
                        </li>
                        <li className="nav-item me-3">
                            <Link className="nav-link" to="/products">Products</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}