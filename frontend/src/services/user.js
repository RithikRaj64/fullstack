import instance from "./axios"

const api_url = "http://localhost:8080/api/v1";

// Institute
export const allIns = () => instance.get(`${api_url}/institute/get`);
export const getIns = (id) => instance.get(`${api_url}/institute/get/${id}`);

// Course
export const getAllCourse = () => instance.get(`${api_url}/course/get`);
export const getCourse = (id) => instance.get(`${api_url}/course/get/${id}`);
export const getFee = (id) => instance.get(`${api_url}/course/get/fee/${id}`);

// Profile
export const getStuId = (id) => instance.get(`${api_url}/user/getStu/${id}`)
export const getDetails = (id) => instance.get(`${api_url}/student/get/${id}`);
export const getUser = (id) => instance.get(`${api_url}/user/get/${id}`);
export const updateDetails = (id, data) => instance.patch(`${api_url}/student/updateDetails/${id}`, data);


// Application
export const apply = (data) => instance.post(`${api_url}/application/add`, data);
export const getAllApplications = () => instance.get(`${api_url}/application/get`);
export const getUserFromStudent = (id) => instance.get(`${api_url}/user/get/user/stu/${id}`);
export const getAllApplicationsInstitutes = (id) => instance.get(`${api_url}/application/get/institute/${id}`);
export const getAllApplicationsStudent = (id) => instance.get(`${api_url}/application/get/student/${id}`);


// Transaction
export const pay = (data) => instance.post(`${api_url}/transaction/add`, data);
export const allTrans = () => instance.get(`${api_url}/transaction/get`); 