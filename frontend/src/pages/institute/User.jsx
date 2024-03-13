import { useEffect, useState } from "react";

import User from "../../assets/images/User.png";

// import ProfileCourses from "../../components/ui/user/ProfileCourses";

import { useSelector } from "react-redux";
import { getDetails, getUserFromStudent } from "../../services/user";
import { getUserId } from "../../redux/viewSlice";

function Profile() {

  const stuId = useSelector(getUserId);

  const [user, setUser] = useState({});
  const [details, setDetails] = useState({});

  const getDets = async () => {
    let user = await getUserFromStudent(stuId);
    setUser(user.data);
    let dets = await getDetails(stuId);
    setDetails(dets.data);
    console.log(user.data);
    console.log(dets.data);
  }

  useEffect(() => {
    getDets();
  }, []);

  return (
    <div className="bg-sky-200 min-h-screen p-12 font-mono">
      <div className="text-2xl font-bold flex justify-center mb-5 tracking-tight">
        <p>Profile</p>
      </div>
      <div className="bg-white border border-gray-200 rounded-lg p-12">
        <div className="flex justify-center">
          <div className="relative">
            <img
              src={User}
              className="rounded-full w-48 h-48 mb-4"
              alt="User"
            />

            
          </div>
        </div>

        <div className="mt-10 flex flex-col space-y-8 mb-10">
          <div className="border border-gray-200 p-8 rounded-lg">
            <div className="mb-6">
              <div className="flex flex-row justify-between items-center  mb-2">
                <p className="font-bold text-2xl">Information:</p>
                
              </div>
              <hr></hr>
            </div>
            <div>
             
                <div className="grid grid-cols-2">
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">Name</p>
                      <p className="">{user.name}</p>
                    </div>
                    <div>
                      <p className="font-bold">DOB</p>
                      <p className="">{details.dob.substring(0,10)}</p>
                    </div>
                    <div>
                      <p className="font-bold">Gender</p>
                      <p className="">{details.gender}</p>
                    </div>
                    <div>
                      <p className="font-bold">Aadhar No</p>
                      <p className="">{details.aadharNo}</p>
                    </div>
                    <div>
                      <p className="font-bold">Father Name</p>
                      <p className="">{details.fatherName}</p>
                    </div>
                    <div>
                      <p className="font-bold">10th Percentage</p>
                      <p className="">{details.tenthPercentage}%</p>
                    </div>
                    <div>
                      <p className="font-bold">12th Percentage</p>
                      <p className="">{details.twelthPercentage}%</p>
                    </div>
                  </div>
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">Email</p>
                      <p className="">{user.email}</p>
                    </div>
                    <div>
                      <p className="font-bold">Mobile</p>
                      <p className="">{user.mobile}</p>
                    </div>
                    <div>
                      <p className="font-bold">Nationality</p>
                      <p className="">{details.nationality}</p>
                    </div>
                    <div>
                      <p className="font-bold">EMIS No</p>
                      <p className="">{details.emisNo}</p>
                    </div>
                    <div>
                      <p className="font-bold">Mother Name</p>
                      <p className="">{details.motherName}</p>
                    </div>
                    <div>
                      <p className="font-bold">10th Board</p>
                      <p className="">{details.tenthBoard}</p>
                    </div>
                    <div>
                      <p className="font-bold">12th Board</p>
                      <p className="">{details.twelthBoard}</p>
                    </div>
                  </div>
                </div>
             
            </div>
          </div>
          {/* <div className="border border-gray-200 p-6 rounded-lg">
            <div className="mb-6">
              <div className="flex flex-row justify-between items-center  mb-2">
                <p className="font-bold text-2xl">Educational Information:</p>
                {eduState ? (
                  <button
                    className="bg-blue-600 hover:bg-sky-800 border border-gray-200 rounded-lg p-1 px-3 text-white"
                    onClick={() => setEduState(!eduState)}
                    >
                    <div className="flex flex-row space-x-2">
                      <div className="mt-1">
                        <PencilSVG />
                      </div>
                      <p>Edit Details</p>
                    </div>
                  </button>
                ) : (
                  <button
                    className="bg-green-600 hover:bg-green-800 border border-gray-200 rounded-lg p-1 px-3 text-white"
                    onClick={() => setEduState(!eduState)}
                  >
                    <div className="flex flex-row space-x-2">
                      <div className="mt-1">
                        <SaveSVG />
                      </div>
                      <p>Save Details</p>
                    </div>
                  </button>
                )}
              </div>
              <hr></hr>
            </div>
            <div>
              {eduState ? (
                <div className="grid grid-cols-2">
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">10th Percentage</p>
                      <p className="">{details.tenthPercentage}%</p>
                    </div>
                    <div>
                      <p className="font-bold">12th Percentage</p>
                      <p className="">{details.twelthPercentage}%</p>
                    </div>
                  </div>
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">10th Board</p>
                      <p className="">{details.tenthboard}</p>
                    </div>
                    <div>
                      <p className="font-bold">12th Board</p>
                      <p className="">{details.twelthBoard}</p>
                    </div>
                  </div>
                </div>
              ) : (
                <div className="grid grid-cols-2">
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">10th Percentage</p>
                      <input
                        type="number"
                        name="tenthPercentage"
                        min="0"
                        max="100"
                        className="b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600"
                        placeholder={details.tenthPercentage}
                        onChange={handleChange}
                        />
                    </div>
                    <div>
                      <p className="font-bold">12th Percentage</p>
                      <input
                        type="number"
                        name="twelthPercentage"
                        min="0"
                        max="100"
                        className="b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600"
                        placeholder={details.twelthPercentage}
                        onChange={handleChange}
                        />
                    </div>
                  </div>
                  <div className="flex flex-col space-y-6">
                    <div>
                      <p className="font-bold">10th Board</p>
                      <input
                        type="text"
                        name="tenthBoard"
                        className="b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600"
                        placeholder={details.tenthBoard}
                        onChange={handleChange}
                        />
                    </div>
                    <div>
                      <p className="font-bold">12th Board</p>
                      <input
                        type="text"
                        name="twelthBoard"
                        className="b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600"
                        placeholder={details.twelthBoard}
                        onChange={handleChange}
                        />
                    </div>
                  </div>
                </div>
              )} */}
            {/* </div> */}
          {/* </div> */}
        </div>

        
      </div>
    </div>
  );
}




export default Profile;

// import { useState } from 'react'

// import User from '../../assets/images/User.png'

// import ProfileCourses from "../../components/ui/user/ProfileCourses"

// function Profile() {
//     const [isForm, setIsForm] = useState(true);

//     return (
//         <div className="bg-sky-200 min-h-screen p-12 font-mono">
//             <div className="text-2xl font-bold flex justify-center mb-5 tracking-tight">
//                 <p>Profile</p>
//             </div>
//             <div className="bg-white border bordeer-gray-200 rounded-lg p-24">
//             <div>
//                {
//                     isForm ? (
//                         <div className="grid grid-cols-5 mb-16">
//                             <div className='flex items-center col-span-1'>
//                                 <img src={User} className='rounded-full w-24 h-24 mb-4'></img>
//                             </div>
//                             <div className="grid grid-cols-subgrid cols-span-4 leading-8 space-y-2">

//                                 <div>
//                                     <p className="font-bold mt-8">General Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Name</p>
//                                     <p className=''>Rithik Raj</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">DOB</p>
//                                     <p className=''>06/04/2004</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Gender</p>
//                                     <p className=''>Male</p>
//                                 </div>

//                                 <div>
//                                     <p className="font-bold mt-8">Contact Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Email</p>
//                                     <p className=''>rithu0644@gmail.com</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Mobile</p>
//                                     <p className=''>9345049320</p>
//                                 </div>

//                                 <div>
//                                     <p className="font-bold mt-8">Educational Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">10th</p>
//                                     <p className=''>95%</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">12th/Diploma</p>
//                                     <p className=''>94%</p>
//                                 </div>

//                                 <div>
//                                     <button className='bg-green-600 hover:bg-green-800 border border-gray-200 rounded-lg p-1 px-3 text-white mt-8' onClick={() => {setIsForm(!isForm)}}>
//                                         Edit Details
//                                     </button>
//                                 </div>
//                             </div>
//                         </div>

//                     ) : (

//                         <div className="grid grid-cols-5 mb-16">
//                             <div className='flex items-center col-span-1'>
//                                 <img src={User} className='rounded-full w-24 h-24 mb-4'></img>
//                             </div>
//                             <div className="grid grid-cols-subgrid cols-span-4 leading-8 space-y-2">

//                                 <div>
//                                     <p className="font-bold mt-8">General Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Name</p>
//                                     <input type="text" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='Rithik Raj'/>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">DOB</p>
//                                     <input type="text" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='06/04/2004'/>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Gender</p>
//                                     <select type="text" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600'>
//                                         <option value="M">Male</option>
//                                         <option value="F">Female</option>
//                                         <option value="O">Prefer not to say</option>
//                                     </select>
//                                 </div>

//                                 <div>
//                                     <p className="font-bold mt-8">Contact Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Email</p>
//                                     <input type="email" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='rithu0644@gmail.com'/>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">Mobile</p>
//                                     <input type="text" pattern='[0-9]{10}' className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='9345049320'/>
//                                 </div>

//                                 <div>
//                                     <p className="font-bold mt-8">Educational Information:</p>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">10th</p>
//                                     <input type="number" min="0" max="100" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='95'/>
//                                 </div>

//                                 <div className='grid grid-cols-2'>
//                                     <p className="font-bold">12th/Diploma</p>
//                                     <input type="number" min="0" max="100" className='b-2 text-sm bg-sky-200 text-gray-900 rounded-md p-1 border-2 border-gray-600' placeholder='94'/>
//                                 </div>

//                                 <div>
//                                     <button className='bg-green-600 hover:bg-green-800 border border-gray-200 rounded-lg p-1 px-3 text-white mt-8' onClick={() => {setIsForm(!isForm)}}>
//                                         Save Details
//                                     </button>
//                                 </div>
//                             </div>
//                         </div>
//                     )
//                 }
//             </div>
//             <div>
//                 <hr className='bg-black border border-black mb-8'></hr>

//                 <div className='flex justify-center mb-8 font-bold text-lg'>
//                     <h1>Course Status</h1>
//                 </div>

//                 <div className='flex flex-col space-y-3'>
//                     <ProfileCourses />
//                     <ProfileCourses />
//                     <ProfileCourses />
//                     <ProfileCourses />
//                     <ProfileCourses />
//                     <ProfileCourses />
//                     <ProfileCourses />
//                 </div>
//             </div>
//             </div>
//         </div>

//     );
// }

// export default Profile;
