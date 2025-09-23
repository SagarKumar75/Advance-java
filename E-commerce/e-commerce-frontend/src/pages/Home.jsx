import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"; // Import useLocation

import axios from "axios";
import { Card } from "../Components/Card";

export const Home = () => {
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const res = await axios.get(`http://localhost:8080/api/products`);

        setProducts(res.data);
      } catch (err) {
        console.log(err);
      }
    };
    fetchProducts();
  }, []); // Re-run the effect when the URL search params change

  const handleClick = (id) => {
    navigate(`/product/${id}`);
  };

  const handleAddProduct = () => {
    navigate("/add-product");
  };

  return (
    <div>
      <div>
        <button onClick={() => handleAddProduct()}>Add Product</button>
      </div>
      <h2 className="text-2xl font-bold text-center my-8">Products List</h2>
      {products.length === 0 ? (
        <p className="text-center">No products found.</p> // Modified message
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          {products.map((product) => (
            <Card
              key={product.id}
              product={product}
              onClick={() => handleClick(product.id)}
            />
          ))}
        </div>
      )}
    </div>
  );
};
