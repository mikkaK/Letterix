import { useFormik } from "formik";
import {CoverLetterModel} from "../../../types/models/CoverLetterModel.model";
import {useNavigate} from "react-router-dom";
import CoverLetterForm from "../../organisms/CoverLetterForm";
import GeneralBox from "../../molecules/GeneralBox";
import CoverLetterService from "../../../Services/CoverLetterService";
import * as Yup from 'yup';


export const initialCoverLetterValues: any = {
    id: '',
    name: '',
    surname: '',
    age: '',
    appliedCompany: '',
    position: '',
    currentEducationLevel: '',
    skills: '',
    interests: '',
    weaknesses: '',
};

const validationSchema = Yup.object({
    id: Yup.string()
        .required('ID is required'),
    name: Yup.string()
        .required('Name is required'),
    surname: Yup.string()
        .required('Surname is required'),
    age: Yup.string()
        .required('Age is required'),
    appliedCompany: Yup.string()
        .required('Applied Company is required'),
    position: Yup.string()
        .required('Position is required'),
    currentEducationLevel: Yup.string()
        .required('Current Education Level is required'),
    skills: Yup.string()
        .required('Skills are required'),
    interests: Yup.string()
        .required('Interests are required'),
    weaknesses: Yup.string()
        .required('Weaknesses are required'),
});

const CoverLetter = () => {
    const navigate = useNavigate();
    const formik = useFormik({
        initialValues: initialCoverLetterValues,
        validationSchema: validationSchema,
        onSubmit: (values) => {
            const coverLetter = values as CoverLetterModel;
            coverLetter.skills = values.skills.split(',');
            coverLetter.weaknesses =values.weaknesses.split(',');
            coverLetter.interests = values.interests.split(',');
            CoverLetterService.addCoverLetter(coverLetter).then((res) => {
                navigate("/generatedCoverLetter/"+res.toString());

            }).catch((res) => {
                alert("Check your Inputs");
            });
        },
    });

    return (
        <GeneralBox title={"Create cover letter"} content={<CoverLetterForm formik={formik}/>}/>
    );
};

export default CoverLetter;
