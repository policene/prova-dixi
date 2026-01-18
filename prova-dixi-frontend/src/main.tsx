import { StrictMode } from 'react'
import ReactDOM from 'react-dom/client'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { BaterPonto } from './pages/BaterPonto.tsx'
import { Historico } from './pages/Historico.tsx'


ReactDOM.createRoot(document.getElementById("root")!).render(
  <BrowserRouter>
    <Routes>

      <Route element={<App/>}>
        <Route path="/" element={<BaterPonto />} />
        <Route path="/bater-ponto" element={<BaterPonto />} />
        <Route path="/historico" element={<Historico />} />
      </Route>

    </Routes>
  </BrowserRouter>
)

