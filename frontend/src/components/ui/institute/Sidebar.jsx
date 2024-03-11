import icon from "../../../assets/images/Icon.png";

import { useNavigate } from "react-router-dom";

import { useDispatch, useSelector } from "react-redux";
import { logoutRedux, getName } from "../../../redux/authSlice";

import { logout } from "../../../services/auth.js"

function Sidebar() {

  const nav = useNavigate();
  const dispatch = useDispatch();

  const name = useSelector(getName);
  
  const handleLogout = async () => {
    try {
      await logout();
      dispatch(logoutRedux());
      nav("/signin");
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <div className="flex font-mono min-h-screen">
      <div className="bg-blue-600 w-64 p-5 text-white">

        <div className="flex space-x-2 mb-8">
          <img className="h-6 w-6" src={icon} alt="icon" />
          <h1 className="text-white font-bold">EduConnect</h1>
        </div>

        <ul className="space-y-4 text-sm">
          <li>
            <a href="/institute/profile" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Profile</a>
          </li>
          <li>
            <a href="/institute/courses" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Courses</a>
          </li>
          <li>
            <a href="/institute/applications" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Applications</a>
          </li>
        </ul>

        <div className="mt-64 pt-48">
          <p className="text-white font-bold mb-2 ">Welcome {name}</p>

          <ul>
            <li>
              <button onClick={handleLogout} className="font-bold text-sm hover:text-sky-200 hover:underline hover:underline-offset-8">Logout</button>
            </li>
          </ul>
        </div>

      </div>
    </div>
  );
}

export default Sidebar;
