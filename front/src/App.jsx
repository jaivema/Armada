import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Layout from "./layout/Layout"
import Welcome from "./pages/Welcome"
import Home from "./pages/Home"
import History from "./pages/History"
import Shop from "./pages/Shop"
import About from "./pages/About"

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Welcome />} />
          <Route path="home" element={<Home />} />
          <Route path="history" element={<History />} />
          <Route path="shop" element={<Shop />} />
          <Route path="about" element={<About />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
