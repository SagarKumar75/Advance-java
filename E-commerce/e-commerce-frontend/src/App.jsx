import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Home } from "./pages/Home";
import { About } from "./pages/About";
import { Contact } from "./pages/Contact";
import { Navbar } from "./Components/Navbar";
import { ProductDetails } from "./pages/ProductDetails";
import { AddProduct } from "./pages/AddProduct";
import { UpdateProduct } from "./pages/UpdateProduct";
export const App = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/product/:id" element={<ProductDetails />} />
        <Route path="/add-product" element={<AddProduct />} />
        <Route path="/update-product/:id" element={<UpdateProduct />} />
      </Routes>
    </BrowserRouter>
  );
};
