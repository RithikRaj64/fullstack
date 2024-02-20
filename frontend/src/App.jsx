import { Navigate, Route, Routes } from 'react-router-dom'
import { lazy } from 'react'
import LazyLayout from './components/ui/LazyLayout'
import UserLayout from './pages/user/UserLayout'
import AdminLayout from './pages/admin/AdminLayout'

const LazyLogin = lazy(() => import('./pages/auth/Login'))

const LazyDashboard = lazy(() => import('./pages/admin/Dashboard'))
const LazyUserInfo = lazy(() => import('./pages/admin/UserInfo'))

const LazyHome = lazy(() => import('./pages/user/Home'))
const LazyAbout = lazy(() => import('./pages/user/About'))

const AdminRoutes = () => {
  return (
    <AdminLayout>
      <Routes>
        <Route path='/dashboard' element={<LazyLayout component={LazyDashboard} />} />
        <Route path='/user-info' element={<LazyLayout component={LazyUserInfo} />} />
      </Routes>
    </AdminLayout>
  )
}

const UserRoutes = () => {
  return (
    <UserLayout>
      <Routes>
          <Route path="/home" element={<LazyLayout component={LazyHome} />} />
          <Route path="/about" element={<LazyLayout component={LazyAbout} />} />
      </Routes>
    </UserLayout>
  )
}

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} />
      <Route path="/login" element={<LazyLayout component={LazyLogin} />} />
      <Route path="/admin/*" element={<AdminRoutes />} />
      <Route path="/user/*" element={<UserRoutes />} />
    </Routes>
  )
}

export default App
