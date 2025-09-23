import { Link } from "react-router-dom";

export const Navbar = () => {
  return (
    <nav className="bg-gray-800 text-white">
      <div className="container mx-auto px-4">
        <div className="flex justify-between items-center py-4">
          <div className="text-2xl font-bold">
            <Link to="/">E-Commerce-App</Link>
          </div>
          <div className="flex space-x-4">
            <Link to="/" className="hover:text-gray-400">
              Home
            </Link>
            <Link to="/about" className="hover:text-gray-400">
              About
            </Link>
            <Link to="/contact" className="hover:text-gray-400">
              Contact
            </Link>
          </div>
        </div>
      </div>
    </nav>
  );
};
