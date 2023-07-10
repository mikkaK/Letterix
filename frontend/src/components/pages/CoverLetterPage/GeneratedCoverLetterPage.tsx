import GeneralBox from "../../molecules/GeneralBox";
import CoverLetterContentBox from "../../organisms/CoverLetterContentBox";
import {useParams} from "react-router-dom";

const CoverLetter = () => {
    const { object } = useParams();
    const decodedObject = JSON.parse(decodeURIComponent(object!));
    return (
       <GeneralBox title={"Your cover letter"} content={<CoverLetterContentBox decodedObject={decodedObject}/>}/>
    );
};

export default CoverLetter;
