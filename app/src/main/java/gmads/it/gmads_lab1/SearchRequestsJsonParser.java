package gmads.it.gmads_lab1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gmads.it.gmads_lab1.model.Book;

public class SearchRequestsJsonParser
{
    private RequestJsonParser movieParser = new RequestJsonParser();
    public List<ReferenceRequest> parseResults(JSONObject jsonObject)
    {
        if (jsonObject == null)
            return null;
        List<ReferenceRequest> results = new ArrayList<>();
        JSONArray hits = jsonObject.optJSONArray("hits");
        if (hits == null)
            return null;
        for (int i = 0; i < hits.length(); ++i) {
            JSONObject hit = hits.optJSONObject(i);
            if (hit == null)
                continue;
            ReferenceRequest movie = movieParser.parse(hit);
            if (movie == null)
                continue;
            results.add(movie);
        }
        return results;
    }
}
