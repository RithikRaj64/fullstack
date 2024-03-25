import { useEffect, useState } from "react";

import { getInstId } from "../../services/institute";
import { useSelector } from "react-redux";
import { getId } from "../../redux/authSlice";
import ApplicationCard from "../../components/ui/institute/ApplicationCard";
import { getAllApplicationsInstitutes } from "../../services/user";

function Courses() {
  const userId = useSelector(getId);

  const [instId, setInstId] = useState(userId);

  // const getInsId = async () => {
  //   let res = await getInstId(userId);
  //   setInsId(res.data.message);
  // }
    
    const [applications, setApplications] = useState([]);

    const getDetails = async () => {
        let instRes = await getInstId(userId);
        let insId = instRes.data.message;
        setInstId(insId);
        let res = await getAllApplicationsInstitutes(insId);
        setApplications(res.data);
        console.log(res.data);  
    }

    useEffect(() => {  
      getDetails();
    },[]);

    return (
    <div className="bg-sky-200 min-h-screen p-12">
      <div className="mb-5 mx-5 flex justify-center">
        
      </div>
      <div className="pr-9">
        {
          applications.map((application) => {
            return <ApplicationCard key={application.id} data={application} />
          })
        }
      </div>

     
    </div>
  );
}

export default Courses;