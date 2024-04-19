import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./layout/Layout";
import Home from "./pages/Home";
import History from "./pages/History";
import Shop from "./pages/Shop";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="history" element={<History />} />
          <Route path="shop" element={<Shop />} />
          
        </Route>
      </Routes>
    </BrowserRouter>

  );
}
