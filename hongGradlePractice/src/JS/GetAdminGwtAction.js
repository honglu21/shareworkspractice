import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 10,
//  duration: '30s',
  stages: [
    { duration: '10s', target: 2},
    { duration: '10s', target: 8},
    { duration: '10s', target: 2},
  ],
};

export default function () {
  const resp = http.get('https://sum-a-test.shareworks.com/solium/servlet/adminGwtAction.do');
  //console.log("resp body: " + resp.body);
  check(resp, {'http response status is 200' : (r) => r.status == 200});
  sleep(1);
}