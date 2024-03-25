import { useSelector } from "react-redux";
import CourseCard from "../../components/ui/user/CourseCard";
import { getId } from "../../redux/authSlice";
import { getAllCourseInstitute } from "../../services/institute";
import { getStuId } from "../../services/user";
import { useEffect, useState } from "react";

function SelectedCourses() {

  const userId = useSelector(getId);

  const [courses, setCourses] = useState([]);
  const [studId, setStudId] = useState("");

  const getCourses = async () => {
    let studres = await getStuId(userId);
    let stuId = studres.data.message;
    setStudId(stuId);
    let res = await getAllCourseInstitute(stuId);
    setCourses(res.data);
    console.log(res.data);
  }

  useEffect(() => {
    getCourses();
  }, []);

  return (
    // <div className={`bg-[url(../../assets/images/Course.jpg)] bg-cover backdrop-blur-lg min-h-screen p-12`}>
    <div className="bg-sky-200 min-h-screen p-12">
      {/* <div className="items-center">
        <div className="mb-5 mx-5 flex items-center">
          <div className="relative w-full">
            <input type="text" id="simple-search" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-8 p-2.5" placeholder="Search course name..." required />
          </div>
          <button type="submit" className="p-2.5 ms-2 text-sm font-medium text-white bg-blue-700 rounded-lg border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300">
            <svg className="w-4 h-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"/>
            </svg>
            <span className="sr-only">Search</span>
        </button>
        </div>
      </div> */}
      <div className="pr-9">
        {
          courses.map((course) => {
            return <CourseCard key={course.id} data={course} />
          })
        }
      </div>
    </div>
  );
}

export default SelectedCourses;
