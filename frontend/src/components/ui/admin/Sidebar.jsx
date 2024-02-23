import { useState } from "react";
import icon from "../../../assets/images/Icon.png";
import dropdown from "../../../assets/images/dropdown.png";

const name = "Rithik Raj";

function Sidebar() {
  const [menuOpen, setMenuOpen] = useState(false);

  return (
    <div className="flex h-screen font-mono">
      <div className="bg-blue-600 w-64 p-5 text-white">

        <div className="flex space-x-2 mb-8">
          <img className="h-6 w-6" src={icon} alt="icon" />
          <h1 className="text-white font-bold">EduConnect</h1>
        </div>

        <ul className="space-y-4 text-sm">
          <li>
            <a href="/admin/dashboard" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Dashboard</a>
          </li>
          <li>
            <a href="/admin/users" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Users</a>
          </li>
          <li>
            <a href="/admin/institutes" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Institutes</a>
          </li>
          <li>
            <a href="/admin/courses" className="font-bold hover:text-sky-200 hover:underline hover:underline-offset-8">Courses</a>
          </li>
        </ul>

        <div className="flex space-x-2 mt-8 align-bottom">
            <p className="text-white font-bold">Welcome {name}</p>
            <img className="h-6 w-6 cursor-pointer" src={dropdown} onClick={() => setMenuOpen(!menuOpen)} />

            {menuOpen && (
              <div className="absolute left-3 mt-9 bg-sky-100 border border-gray-300 rounded shadow-md text-sm text-black">
                  <ul className="">
                  <li className="px-16 py-3 hover:bg-sky-300 cursor-pointer"><a href="/admin/profile">Profile</a></li>
                  <li className="px-16 py-3 hover:bg-sky-300 cursor-pointer"><a href="/signin">Logout</a></li>
                  </ul>
              </div>
            )}
        </div>

      </div>
    </div>
  );
}

export default Sidebar;
