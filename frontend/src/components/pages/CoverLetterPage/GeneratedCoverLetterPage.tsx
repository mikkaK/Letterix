import GeneralBox from "../../molecules/GeneralBox";
import CoverLetterContentBox from "../../organisms/CoverLetterContentBox";
//import {useParams} from "react-router-dom";
import { useLocation } from 'react-router-dom';


const CoverLetter = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    //const { data } = useParams();
    const encodedData:any = queryParams.get('data');
    //const jsonData = JSON.parse(decodeURIComponent(encodedData));
    const decodedObject = JSON.parse(decodeURIComponent(encodedData!));
    return (
       <GeneralBox title={"Your cover letter"} content={<CoverLetterContentBox decodedObject={decodedObject}/>}/>
    );
};

export default CoverLetter;
