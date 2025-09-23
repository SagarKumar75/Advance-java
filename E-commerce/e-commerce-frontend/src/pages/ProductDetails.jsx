import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export const ProductDetails = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const res = await axios.get(`http://localhost:8080/api/products/${id}`);
        setProduct(res.data);
      } catch (err) {
        console.log(err);
      } finally {
        setLoading(false);
      }
    };
    fetchProduct();
  }, [id]);

  const handleUpdate = (id) => {
    navigate(`/update-product/${id}`);
  };

  const handleDelete = async (id) => {
    try {
      const res = await axios.delete(
        `http://localhost:8080/api/products/${id}`
      );
      if (res.status === 200 || res.status === 201) {
        alert("Product deleted successfully");
        navigate("/");
      }
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="container mx-auto mt-8">
      {loading ? (
        <p>Loading...</p>
      ) : product ? (
        <div className="max-w-2xl mx-auto bg-white rounded-lg shadow-md overflow-hidden">
          <div className="p-6">
            <h2 className="text-3xl font-bold mb-2">{product.name}</h2>
            <p className="text-gray-700 text-base mb-4">
              {product.description}
            </p>
            <div className="flex justify-between items-center">
              <span className="text-2xl font-bold text-gray-900">
                ${product.price}
              </span>
              <span
                className={`px-3 py-1 rounded-full text-sm font-semibold ${
                  product.available
                    ? "bg-green-200 text-green-800"
                    : "bg-red-200 text-red-800"
                }`}
              >
                {product.available ? "Available" : "Out of stock"}
              </span>
            </div>
          </div>
          <div className="p-6 flex justify-center items-center space-x-4 bg-gray-50">
            <button
              onClick={() => handleUpdate(product.id)}
              className="w-full md:w-auto px-6 py-3 bg-blue-600 text-white font-semibold rounded-lg shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-75"
            >
              Update
            </button>
            <button
              onClick={() => handleDelete(product.id)}
              className="w-full md:w-auto px-6 py-3 bg-red-600 text-white font-semibold rounded-lg shadow-md hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-red-500 focus:ring-opacity-75"
            >
              Delete
            </button>
          </div>
        </div>
      ) : (
        <p>Product not found</p>
      )}
    </div>
  );
};
