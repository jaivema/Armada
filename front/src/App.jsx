import { BrowserRouter, Routes, Route } from "react-router-dom"
import Home from "./pages/Home"
import History from "./pages/History"
import Shop from "./pages/Shop"
import "./App.css"

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<Home />} />
          <Route path="history" element={<History />} />
          <Route path="shop" element={<Shop />} />
      </Routes>
    </BrowserRouter>
  );
}
