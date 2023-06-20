import api from '../config/Api';
import { CoverLetter } from '../types/models/CoverLetter.model';

const CoverLetterService = {
    addCoverLetter: (coverLetter: CoverLetter) => {
        return api.post('/coverLetter/', coverLetter).then((res) => {
            return res.data;
        });
    },
};

export default CoverLetterService;
