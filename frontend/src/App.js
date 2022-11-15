import { Routes, Route } from 'react-router-dom'
import routes from './routes'

function App() {
  const { publicRoutes } = routes;
  return (
    <Routes>
      {/* public routes */}
      {
        publicRoutes.map(route => (
          <Route key={route.id} path={route.path} element={route.page}></Route>
        ))
      }
    </Routes>
  );
}

export default App;
